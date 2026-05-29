import Container from "@/src/common/components/elements/Container";
import PageHeading from "@/src/common/components/elements/PageHeading";
import Logout from "@/src/modules/logout";

const PAGE_TITLE = "🔒 Confirm Logout"
const PAGE_DESCRIPTION = "Logging out will end your current session and pause access to notification management features."

export default function Page(){
    return(
        <div>
            <Container data-aos="fade-up">
                <div className="w-full">
                    <PageHeading title={PAGE_TITLE} description={PAGE_DESCRIPTION}/>
                </div>
                <Logout></Logout>
            </Container>
        </div>
    )
}