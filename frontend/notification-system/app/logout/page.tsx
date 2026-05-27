import Container from "@/src/common/components/elements/Container";
import PageHeading from "@/src/common/components/elements/PageHeading";
import Logout from "@/src/modules/logout";

const PAGE_TITLE = ""
const PAGE_DESCRIPTION = ""

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