'use client'
import { useTheme } from "next-themes"
import { ReactNode } from "react"
import useHasMounted from "../../hooks/useHasMounted"
import clsx from "clsx"
import HeaderSidebar from "./header/HeaderSideBar"

interface LayoutProps {
    children: ReactNode
}

const Layout = ({children}: LayoutProps) => {
    const {resolvedTheme} = useTheme();   // for the themes 
    const hasMounted = useHasMounted();

    const isDarkTheme = hasMounted && (resolvedTheme === 'dark' || resolvedTheme === 'system')   // setting the theme variables 

    return (
        <div
            className={clsx(
                'max-w-6xl mx-auto lg:px-8',
                isDarkTheme ? 'dark:text-darkText' : '',
            )}
        >
            <div className='flex flex-col lg:flex-row lg:gap-5 lg:py-4 xl:pb-8'>
                <HeaderSidebar />
                <main className='lg:w-4/5 max-w-[854px] transition-all duration-300'>
                    {children}
                </main>
            </div>
        </div>
    )
}

export default Layout;