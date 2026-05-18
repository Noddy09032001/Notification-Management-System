import ProgressBar from "@/src/common/components/elements/ProgressBar";
import "./globals.css";
import Providers from "./providers";
import { firaCode, jakartaSans, soraSans } from "@/src/common/styles/fonts";
import Layout from "@/src/common/components/layout";

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
          <Layout>{children}</Layout>
        </Providers>
      </body>
    </html>
  );
}