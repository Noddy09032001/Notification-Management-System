const Introduction = () => {
    return (
        <section className='bg-cover bg-no-repeat'>
            <div className='space-y-4'>
                <div className='flex gap-2 text-2xl lg:text-3xl font-medium font-sora'>
                    <h1>Notification Dashboard</h1>
                </div>

                <p className='text-neutral-700 dark:text-neutral-400 leading-7 max-w-3xl'>
                    Unified notification management platform for handling
                    broadcast messaging, retry orchestration, analytics,
                    and operational monitoring across multiple communication channels.
                </p>

                <ul className='flex flex-col lg:flex-row gap-1 lg:gap-10 ml-5 list-disc text-neutral-700 dark:text-neutral-400'>
                    <li>
                        Real-time delivery monitoring
                    </li>
                    <li>
                        Retry queue & failure tracking
                    </li>
                    <li>
                        RBAC-enabled notification management
                    </li>
                </ul>
            </div>
        </section>
    );
};

export default Introduction;