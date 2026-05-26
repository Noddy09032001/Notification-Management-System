import ProgressBar from "@/src/common/components/elements/ProgressBar";
import "./globals.css";
import Providers from "./providers";
import { firaCode, jakartaSans, soraSans } from "@/src/common/styles/fonts";
import Layout from "@/src/common/components/layout";
import LayoutWrapper from "@/src/common/components/layout/LayoutWrapper";

export default function RootLayout({children,}: {children: React.ReactNode;}) {
  return (
    <html
      lang="en"
      suppressHydrationWarning
    >
      <body
        className={`
          ${jakartaSans.variable}
          ${soraSans.variable}
          ${firaCode.variable}
        `}
      >
        <Providers>
          <ProgressBar />
          <LayoutWrapper>{children}</LayoutWrapper>
        </Providers>
      </body>
    </html>
  );
}