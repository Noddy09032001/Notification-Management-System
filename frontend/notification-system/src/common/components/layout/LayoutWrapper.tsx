'use client'

import { useState, useEffect } from "react"
import Layout from "."
import { usePathname } from "next/navigation";

type Props = {
    children: React.ReactNode;
}

const LayoutWrapper = ({children,}: Props) => {

    const pathname = usePathname();

    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const token = localStorage.getItem('token');
        setIsAuthenticated(!!token);
        setLoading(false);
    }, [pathname]);

    // Prevent hydration mismatch
    if (loading) return null;

    // If logged in -> show dashboard layout
    if (isAuthenticated) {
        return (
        <Layout>
            {children}
        </Layout>
        );
    }

    // Else -> show login page only
    return <>{children}</>;
};

export default LayoutWrapper;