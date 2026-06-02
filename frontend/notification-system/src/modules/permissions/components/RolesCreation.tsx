"use client";

import { motion } from "framer-motion";
import { FiShield, FiFileText } from "react-icons/fi";
import { useState } from "react";

export default function RoleCreation() {
  const [roleName, setRoleName] = useState("");
  const [roleDescription, setRoleDescription] = useState("");

  return (
    <motion.div
      initial={{
        opacity: 0,
        y: 20,
      }}
      animate={{
        opacity: 1,
        y: 0,
      }}
      transition={{
        duration: 0.5,
      }}
      className="relative overflow-hidden rounded-3xl border border-neutral-800 bg-neutral-950/80 p-10">

      <div className="absolute top-[-120px] right-[-120px] h-[300px] w-[300px] rounded-full bg-cyan-500/10 blur-3xl" />
      <div className="absolute bottom-[-120px] left-[-120px] h-[250px] w-[250px] rounded-full bg-blue-600/10 blur-3xl" />
      <div className="relative z-10">
        <h2 className="text-4xl font-bold text-white">
          Create Role
        </h2>

        <p className="mt-3 text-neutral-400">
          Create new application roles and manage access control.
        </p>

        <div className="mt-10 space-y-6">

          <div
            className="flex items-center gap-4 h-14 px-5 rounded-2xl bg-neutral-900 border border-neutral-800 focus-within:border-white">
            <FiShield className="text-neutral-500" />

            <input
              value={roleName}
              onChange={(e) =>
                setRoleName(e.target.value)
              }
              placeholder="Role Name"
              className="w-full bg-transparent outline-none text-white placeholder:text-neutral-500"/>
          </div>

          <div
            className="flex gap-4 rounded-2xl bg-neutral-900 border border-neutral-800 p-5 focus-within:border-white">
            <FiFileText className="text-neutral-500 mt-1"/>
            <textarea
              value={roleDescription}
              onChange={(e) =>
                setRoleDescription(
                  e.target.value
                )
              }
              placeholder="Role Description"
              rows={5}
              className="w-full resize-none bg-transparent outline-none text-white placeholder:text-neutral-500"/>
          </div>

          <div className="flex gap-4 pt-2">
            <button
              className="h-14 px-8 rounded-2xl bg-white text-black font-semibold">
              Create Role
            </button>

            <button
              className="h-14 px-8 rounded-2xl border border-neutral-700 text-neutral-300 hover:bg-neutral-900">
              Clear
            </button>
          </div>
        </div>
      </div>
    </motion.div>
  );
}