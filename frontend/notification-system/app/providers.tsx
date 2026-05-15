"use client"

import { useEffect } from "react";
import AOS from "aos";
import { ThemeProvider } from "next-themes";

// code for the dark theme to work for the application
export default function Providers({children} : {children : React.ReactNode}){
    useEffect(() => {
    AOS.init({
      duration: 800,
      delay: 50,
    });
  }, []);

  // setting up the default dark theme for the application 
  return(
    <ThemeProvider
        attribute="class"
        defaultTheme="dark"
        enableSystem={false}
    >{children}</ThemeProvider>
  )
}