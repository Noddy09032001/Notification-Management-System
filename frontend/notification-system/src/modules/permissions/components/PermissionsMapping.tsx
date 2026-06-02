"use client";

import { motion } from "framer-motion";
import { FiShield, FiSave, FiRefreshCw } from "react-icons/fi";
import { useState } from "react";

const roles = [
  {
    id: 1,
    name: "ADMIN",
  },
  {
    id: 2,
    name: "USER",
  },
  {
    id: 3,
    name: "MANAGER",
  },
];

const permissions = [
  "CREATE_USER",
  "DELETE_USER",
  "VIEW_USERS",
  "CREATE_NOTIFICATION",
  "VIEW_ANALYTICS",
  "UPDATE_SETTINGS",
  "ROLE_MANAGEMENT",
  "PERMISSION_MANAGEMENT",
];

export default function RolePermissionMapping() {

  const [selectedPermissions, setSelectedPermissions] = useState<Record<number, string[]>>({});
  const togglePermission = (
    roleId: number,
    permission: string
  ) => {
    setSelectedPermissions((prev) => {
      const current = prev[roleId] || [];

      const updated = current.includes(permission)
        ? current.filter((p) => p !== permission)
        : [...current, permission];

      return {
        ...prev,
        [roleId]: updated,
      };
    });
  };

  const clearRolePermissions = (roleId: number) => {
    setSelectedPermissions((prev) => ({
      ...prev,
      [roleId]: [],
    }));
  };

  const clearAll = () => {
    setSelectedPermissions({});
  };

  return (
    <div className="space-y-8">
      <motion.div
        initial={{
          opacity: 0,
          y: -20,
        }}
        animate={{
          opacity: 1,
          y: 0,
        }}
      >
        <h1 className="text-4xl font-bold text-white">
          Roles & Permissions
        </h1>

        <p className="mt-3 text-neutral-400">
          Assign permissions to application roles.
        </p>
      </motion.div>

      {/* Role Cards */}

      <div className="grid gap-8">
        {roles.map((role, index) => (
          <motion.div
            key={role.id}
            initial={{
              opacity: 0,
              y: 30,
            }}
            animate={{
              opacity: 1,
              y: 0,
            }}
            transition={{
              delay: index * 0.1,
            }}
            className="relative overflow-hidden rounded-3xl border border-neutral-800 bg-neutral-950/80 p-8">
            
            <div className="absolute top-[-120px] right-[-120px] h-[250px] w-[250px] rounded-full bg-cyan-500/10 blur-3xl"/>
            <div className="relative z-10">
            
              <div className="flex items-center gap-4 mb-8">
                <div className="h-12 w-12 rounded-2xl bg-neutral-900 border border-neutral-800 flex items-center justify-center">
                  <FiShield className="text-xl text-cyan-400" />
                </div>

                <div>
                  <h2 className="text-2xl font-bold text-white">
                    {role.name}
                  </h2>

                  <p className="text-neutral-500 text-sm">
                    Configure role permissions
                  </p>
                </div>
              </div>

              {/* Permissions */}

              <div className="flex flex-wrap gap-4">
                {permissions.map((permission) => {
                  const selected =
                    selectedPermissions[
                      role.id
                    ]?.includes(permission);

                  return (
                    <button
                      key={permission}
                      onClick={() =>
                        togglePermission(
                          role.id,
                          permission
                        )
                      }
                      className={`px-5 py-3 rounded-2xl border transition-all text-sm font-medium
                        ${
                          selected ? `bg-white text-black border-white` : `bg-neutral-900 border-neutral-800 text-neutral-400 hover:border-neutral-600`
                        }`}
                    >
                      {permission}
                    </button>
                  );
                })}
              </div>

              {/* Actions */}

              <div className="flex gap-4 mt-8">
                <button className="flex items-center gap-2 h-12 px-6 rounded-2xl bg-white text-black font-semibold">
                  <FiSave />
                  Submit
                </button>

                <button
                  onClick={() =>
                    clearRolePermissions(role.id)
                  }
                  className="flex items-center gap-2 h-12 px-6 rounded-2xl border border-neutral-700 text-neutral-300 hover:bg-neutral-900"
                >
                  <FiRefreshCw />
                  Clear
                </button>
              </div>
            </div>
          </motion.div>
        ))}
      </div>
      <motion.div
        initial={{
          opacity: 0,
        }}
        animate={{
          opacity: 1,
        }}
        className="sticky bottom-6 z-50">
        <div className="backdrop-blur-xl bg-neutral-950/90 border border-neutral-800 rounded-3xl p-6 flex justify-between items-center">
          <div>
            <h3 className="text-white font-semibold">
              Save All Role Mappings
            </h3>

            <p className="text-sm text-neutral-500">
              Submit all configured role permissions.
            </p>
          </div>

          <div className="flex gap-4">
            <button
              className="px-6 h-12 rounded-2xl border border-neutral-700 text-neutral-300"
              onClick={clearAll}
            >
              Clear All
            </button>

            <button
              className="px-8 h-12 rounded-2xl bg-white text-black font-semibold">
              Submit All
            </button>
          </div>
        </div>
      </motion.div>
    </div>
  );
}