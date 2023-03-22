rootProject.name = "study-idleword-coupon"
include("domain")
include("api")
include("batch")

include("infra:infra-mongo")
findProject(":infra:infra-mongo")?.name = "infra-mongo"

include("infra:infra-rds")
findProject(":infra:infra-rds")?.name = "infra-rds"

include("infra:infra-redis")
findProject(":infra:infra-redis")?.name = "infra-redis"

