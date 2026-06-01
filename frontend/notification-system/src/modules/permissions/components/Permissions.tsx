import {
  MdAdminPanelSettings as RolesIcon,
  MdVpnKey as PermissionsIcon,
  MdAccountTree as MappingIcon,
} from 'react-icons/md';

import { Tabs } from '@/src/common/components/elements/Tabs'; 
import PermissionsMapping from './PermissionsMapping';
import PermissionCreation from './PermissionCreation';
import RolesCreation from './RolesCreation';


const Permissions = () => {
  const TABS = [
    {
      label: (
        <TabLabel>
          <RolesIcon size={17} /> Roles
        </TabLabel>
      ),
      children: <RolesCreation />,
    },
    {
      label: (
        <TabLabel>
          <PermissionsIcon size={17} /> Permissions
        </TabLabel>
      ),
      children: <PermissionCreation />,
    },
    {
      label: (
        <TabLabel>
          <MappingIcon size={17} /> Roles and Permissions Mapping
        </TabLabel>
      ),
      children: <PermissionsMapping />,
    },
  ];
  return <Tabs tabs={TABS} />;
};

export default Permissions;

const TabLabel = ({ children }: { children: React.ReactNode }) => (
  <div className='flex items-center justify-center gap-1.5'>{children}</div>
);