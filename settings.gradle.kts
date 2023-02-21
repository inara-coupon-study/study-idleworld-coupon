rootProject.name = "study-idleword-coupon"
include("domain")
include("api")

include("infra:infra-mongo")
findProject(":infra:infra-mongo")?.name = "infra-mongo"

include("infra:infra-rds")
findProject(":infra:infra-rds")?.name = "infra-rds"