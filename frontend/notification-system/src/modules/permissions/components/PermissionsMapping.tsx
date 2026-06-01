"use client";

import { useState } from "react";

const roles = ["ADMIN", "USER", "MODERATOR"];

const permissions = [
  "CREATE_USER",
  "DELETE_USER",
  "VIEW_REPORTS",
  "UPDATE_SETTINGS",
];

const PermissionsMapping = () => {

    const [selectedPermissions, setSelectedPermissions] = useState<Record<string, string[]>>({});
    const handleCheckbox = (role: string, permission: string) => {setSelectedPermissions((prev) => {
        const existing = prev[role] || [];
        if (existing.includes(permission)) {
            return {
            ...prev,
            [role]: existing.filter((p) => p !== permission),
            };
        }
        return {
            ...prev,
            [role]: [...existing, permission],
        };
        });
    };

    return(
        <div>
            <h2 className="text-2xl font-bold mb-8">
                Roles & Permission Mapping
            </h2>

            <div className="overflow-x-auto">
                <table className="w-full border border-zinc-700">
                    <thead className="bg-zinc-800">
                        <tr>
                            <th className="border border-zinc-700 px-5 py-4 text-left">Roles</th>
                            {permissions.map((permission) => (
                                <th key={permission} className="border border-zinc-700 px-5 py-4 text-center">
                                    {permission}
                                </th>
                            ))}

                            <th className="border border-zinc-700 px-5 py-4 text-center">Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        {roles.map((role) => (
                            <tr key={role} className="bg-zinc-900">
                                <td className="border border-zinc-700 px-5 py-4 font-semibold">
                                    {role}
                                </td>

                                {permissions.map((permission) => (
                                    <td key={permission} className="border border-zinc-700 px-5 py-4 text-center">
                                        <input
                                            type="checkbox"
                                            checked={
                                                selectedPermissions[role]?.includes(permission) || false
                                            }
                                            onChange={() => handleCheckbox(role, permission)}
                                            className="h-5 w-5 accent-blue-600"
                                        />
                                    </td>
                                ))}

                                <td className="border border-zinc-700 px-5 py-4">
                                    <div className="flex justify-center gap-3">
                                        <button className="bg-blue-600 hover:bg-blue-700 px-4 py-2 rounded-lg text-sm">
                                            Submit
                                        </button>

                                        <button className="bg-zinc-700 hover:bg-zinc-600 px-4 py-2 rounded-lg text-sm">
                                            Clear
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>

            <div className="flex justify-end gap-4 mt-8">
                <button className="bg-green-600 hover:bg-green-700 px-6 py-3 rounded-lg font-semibold">
                    Submit All
                </button>

                <button className="bg-zinc-700 hover:bg-zinc-600 px-6 py-3 rounded-lg font-semibold">
                    Clear All
                </button>
            </div>
        </div>
    )
}

export default PermissionsMapping;