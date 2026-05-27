const Confirmation = () => {
    return (
        <div className="min-h-screen flex items-center justify-center px-4">
            <div className="w-full rounded-3xl border border-zinc-200 dark:border-zinc-800 bg-white dark:bg-zinc-900 shadow-xl p-8">
                <div className="text-center mt-6">
                    <h1 className="text-2xl font-bold text-zinc-900 dark:text-white">
                        Leave Workspace?
                    </h1>

                    <p className="mt-4 text-zinc-600 dark:text-zinc-400 leading-relaxed">
                        You are about to securely end your active session.
                        Sign back in anytime to continue managing notifications
                        and alerts.
                    </p>
                </div>

                {/* Buttons */}
                <div className="flex gap-4 mt-8">
                    <button
                        className="w-full py-3 rounded-xl border border-zinc-300 dark:border-zinc-700 bg-zinc-100 dark:bg-zinc-800 text-zinc-700 dark:text-zinc-300 font-medium hover:bg-zinc-200 dark:hover:bg-zinc-700 transition-all duration-200 cursor-pointer"
                    >
                        Stay Logged In
                    </button>

                    <button
                        className="w-full py-3 rounded-xl bg-red-500 text-white font-medium hover:bg-red-600 transition-all duration-200 shadow-lg shadow-red-500/20 cursor-pointer"
                    >
                        Logout
                    </button>
                </div>
            </div>
        </div>
    );
};

export default Confirmation;