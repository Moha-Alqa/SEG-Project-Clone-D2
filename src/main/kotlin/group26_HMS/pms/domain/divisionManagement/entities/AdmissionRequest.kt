package group26_HMS.pms.domain.divisionManagement.entities

import java.util.UUID

class AdmissionRequest (
    val id:UUID,
    var rationale:String,
    var priority:Number,
    var localDoctor:String,
    var division:String
) {
}