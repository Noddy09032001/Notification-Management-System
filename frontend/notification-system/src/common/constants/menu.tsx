import { MenuItemProps } from '../types/menu'; 
import {
  BsEnvelopeAtFill as EmailIcon,
  BsGithub as GithubIcon,
  BsInstagram as InstagramIcon,
  BsLinkedin as LinkedinIcon,
  BsTwitter as TwitterIcon,
} from 'react-icons/bs';

import {
  FiBell,
  FiBarChart2,
  FiSend,
  FiRefreshCcw,
  FiLayout,
} from "react-icons/fi";

import {
  FiUsers,
  FiShield,
  FiSettings,
  FiLogOut,
} from "react-icons/fi";

const iconSize = 20;

export const MENU_ITEMS: MenuItemProps[] = [
  {
    title: 'Dashboard',
    href: '/dashboard',
    icon: <FiLayout size={iconSize} />,
    isShow: true,
    isExternal: false,
    eventName: 'Pages: Dashboard',
    type: 'Pages',
  },
  {
    title: 'Broadcast Notification',
    href: '/sendNotification',
    icon: <FiSend size={iconSize} />,
    isShow: true,
    isExternal: false,
    eventName: 'Pages: About',
    type: 'Pages',
  },
  {
    title: 'Notifications',
    href: '/notifications',
    icon: <FiBell size={iconSize} />,
    isShow: true,
    isExternal: false,
    eventName: 'Pages: Projects',
    type: 'Pages',
  },
  {
    title: 'Retry Queues',
    href: '/retryQueue',
    icon: <FiRefreshCcw size={iconSize} />,
    isShow: true,
    isExternal: false,
    eventName: 'Pages: Contact',
    type: 'Pages',
  },
  {
    title: 'Analytics',
    href: '/analytics',
    icon: <FiBarChart2 size={iconSize} />,
    isShow: true,
    isExternal: false,
    eventName: 'Pages: Dashboard',
    type: 'Pages',
  },
];

// defining the navigation items for the rbac settings module

export const RBAC_MODULE: MenuItemProps[] = [
    {
        title: 'Users',
        href: '/users',
        icon: <FiUsers size={iconSize} />,
        isShow: true,
        isExternal: false,
        eventName: 'Pages: Dashboard',
        type: 'Pages',
    },
    {
        title: 'Roles and Permissions',
        href: '/permissions',
        icon: <FiShield size={iconSize} />,
        isShow: true,
        isExternal: false,
        eventName: 'Pages: Dashboard',
        type: 'Pages',
    },
]

export const PROFILE_MODULE: MenuItemProps[] = [
    {
        title: 'Profile Settings',
        href: '/profile',
        icon: <FiSettings size={iconSize} />,
        isShow: true,
        isExternal: false,
        eventName: 'Pages: Dashboard',
        type: 'Pages',
    },
    {
        title: 'Log Out',
        href: '/logout',
        icon: <FiLogOut size={iconSize} />,
        isShow: true,
        isExternal: false,
        eventName: 'Pages: Dashboard',
        type: 'Pages',
    },
]

export const SOCIAL_MEDIA: MenuItemProps[] = [
  {
    title: 'Email',
    href: 'mailto:niranjan.dhokarikar2001@gmail.com',
    icon: <EmailIcon size={iconSize} />,
    isShow: true,
    isExternal: true,
    eventName: 'Contact: Email',
    className: '!bg-red-700 border border dark:border-neutral-700',
    type: 'Link',
  },
  {
    title: 'Linkedin',
    href: 'https://www.linkedin.com/in/niranjan-dhokarikar/',
    icon: <LinkedinIcon size={iconSize} />,
    isShow: true,
    isExternal: true,
    eventName: 'Social: Linkedin',
    className: '!bg-blue-700 border border dark:border-neutral-700',
    type: 'Link',
  },
  {
    title: 'Twitter',
    href: 'https://twitter.com/swanandwagh1208',
    icon: <TwitterIcon size={iconSize} />,
    isShow: true,
    isExternal: true,
    eventName: 'Social: Twitter',
    className: '!bg-sky-400 border border dark:border-neutral-700',
    type: 'Link',
  },
  {
    title: 'Instagram',
    href: 'https://www.instagram.com/swanandaaaaa/',
    icon: <InstagramIcon size={iconSize} />,
    isShow: true,
    isExternal: true,
    eventName: 'Social: Instagram',
    className:
      'bg-gradient-to-r from-purple-500 via-pink-500 to-orange-500 text-white border border dark:border-neutral-700',
    type: 'Link',
  },
  {
    title: 'Github',
    href: 'https://github.com/Swanand-Wagh',
    icon: <GithubIcon size={iconSize} />,
    isShow: true,
    isExternal: true,
    eventName: 'Social: Github',
    className: '!bg-black border border dark:border-neutral-700',
    type: 'Link',
  },
];