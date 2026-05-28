import clsx from 'clsx';
import Link from 'next/link';
import { MdVerified as VerifiedIcon } from 'react-icons/md';

import Image from '../elements/Image';
import Tooltip from '../elements/Tooltip';

interface ProfileHeaderProps {
  expandMenu: boolean;
  imageSize: number;
  isScrolled?: boolean;
}

const ProfileHeader = ({ expandMenu, imageSize }: ProfileHeaderProps) => {
  const userRole: string[] = JSON.parse(localStorage.getItem("roles") || "[]")
  const currentRole = userRole[0]

  const username: any = localStorage.getItem("username")
  

  return (
    <div
      className={clsx(
        'flex items-center lg:items-start gap-4 lg:gap-0.5 flex-grow lg:flex-col w-full',
        expandMenu && 'flex-col !items-start',
      )}
    >
      <Image
        src='/images/careers/relfor.PNG'
        alt='Niranjan Dhokarikar'
        width={expandMenu ? 80 : imageSize}
        height={expandMenu ? 80 : imageSize}
        rounded='rounded-full'
        className='lg:hover:scale-105'
        priority
        sizes='80px'
      />
      <div className='flex gap-2 items-center mt-1 lg:mt-4'>
        <Link href='/' passHref>
          <div className='flex items-center gap-2 text-lg lg:text-xl font-sora font-medium cursor-pointer'>
              <h2 className='flex items-center gap-1'>
                  Hello {username}
                <span className='ml-1 animate-waving-hand'>👋</span>
              </h2>
          </div>
        </Link>
        <Tooltip title='Verified'>
          <VerifiedIcon size={18} className='text-blue-400' />
        </Tooltip>
      </div>
      <div className='hidden lg:flex text-sm font-sora text-neutral-600 hover:text-neutral-700 dark:text-neutral-500 dark:hover:text-neutral-400 transition-all duration-300'>
        @{currentRole}
      </div>
    </div>
  );
};

export default ProfileHeader;