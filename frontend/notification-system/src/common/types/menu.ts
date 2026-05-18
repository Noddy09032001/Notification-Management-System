import type { JSX, ReactNode } from 'react';

// defining the interface and the type for the menu item and the navigation items for the sidebar 
export type MenuItemProps = {
  title: string;
  href: string;
  icon: JSX.Element;
  isShow?: boolean;
  isExternal: boolean;
  onClick?: () => void;
  className?: string;
  children?: ReactNode;
  eventName?: string;
  hideIcon?: boolean;
  type?: string;
};