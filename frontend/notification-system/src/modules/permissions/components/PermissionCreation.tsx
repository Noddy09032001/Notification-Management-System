'use client';

import { useState } from "react";

const PermissionCreation = () => {

    const [permissionName, setPermissionName] = useState("");
    const [permissionDescription, setPermissionDescription] = useState("");

    return(
        <div className="max-w-2xl">
            <h2 className="text-2xl font-bold mb-6">Create Permission</h2>

            <div className="space-y-5">
                <div>
                    <label className="block mb-2 text-sm text-zinc-300">
                        Permission Name
                    </label>

                    <input
                        type="text"
                        value={permissionName}
                        onChange={(e) => setPermissionName(e.target.value)}
                        placeholder="Enter permission name"
                        className="w-full rounded-lg bg-zinc-800 border border-zinc-700 p-3 outline-none focus:border-blue-500"
                    />
                </div>

                <div>
                    <label className="block mb-2 text-sm text-zinc-300">
                        Permission Description
                    </label>

                    <textarea
                        value={permissionDescription}
                        onChange={(e) => setPermissionDescription(e.target.value)}
                        placeholder="Enter permission description"
                        className="w-full rounded-lg bg-zinc-800 border border-zinc-700 p-3 outline-none focus:border-blue-500"
                    />
                </div>

                <div className="flex gap-4">
                    <button className="bg-blue-600 hover:bg-blue-700 px-5 py-3 rounded-lg font-semibold">
                        Submit
                    </button>

                    <button
                        onClick={() => {
                            setPermissionName("");
                            setPermissionDescription("");
                        }}
                        className="bg-zinc-700 hover:bg-zinc-600 px-5 py-3 rounded-lg font-semibold"
                    >
                        Clear
                    </button>
                </div>
            </div>
        </div>
    )
}

export default PermissionCreation;