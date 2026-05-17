"use client";
import NextTopLoader from "nextjs-toploader";

const ProgressBar = () => {

  return (
    <NextTopLoader
      color="#3B82F6"
      initialPosition={0.08}
      crawlSpeed={200}
      height={3}
      crawl={true}
      showSpinner={false}
      easing="ease"
      speed={500}
      shadow="0 0 5px rgba(59,130,246,0.7)"
    />
  );
};

export default ProgressBar;