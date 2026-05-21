import { MENU_ITEMS, PROFILE_MODULE, RBAC_MODULE } from '../../constants/menu'; 
import Breakline from '../elements/Breakline';

import Menu from './Menu';

const Navigation = () => {
  const filterdMenu = MENU_ITEMS?.filter((item) => item?.isShow);   // getting the main modules to show on the sidebar
  const filteredRbac = RBAC_MODULE?.filter((item) => item?.isShow);   // getting the filtered rbac setting modules to show on the sidebar
  const profileModules = PROFILE_MODULE?.filter((item) => item?.isShow);   // getting the profile modules to show on the sidebar 

  return (
    <div>
      <Menu list={filterdMenu} />
      <Breakline></Breakline>
      <Menu list={filteredRbac}/>
      <Breakline/>
      <Menu list={profileModules}/>
    </div>
  );
};

export default Navigation;