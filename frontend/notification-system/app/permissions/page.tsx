import Container from "@/src/common/components/elements/Container"
import PageHeading from "@/src/common/components/elements/PageHeading"
import Permissions from "@/src/modules/permissions"

const PAGE_TITLE = "🛡️ Roles & Permissions"
const PAGE_DESCRIPTION = "Manage roles, permissions, and role-to-permission mappings to control user access across the application."

export default function Page(){
    return(
        <div>
            <Container data-aos="fade-up">
                <div className="w-full">
                    <PageHeading title={PAGE_TITLE} description={PAGE_DESCRIPTION}/>
                </div>
                <Permissions></Permissions>
            </Container>
        </div>
    )
}