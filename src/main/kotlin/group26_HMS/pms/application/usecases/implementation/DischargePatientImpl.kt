package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.DischargePatientDto
import group26_HMS.pms.application.usecases.DischargePatient
import group26_HMS.pms.domain.divisionManagement.facade.DivisionFacade
import java.util.*

class DischargePatientImpl(
    private var divisionFacade: DivisionFacade): DischargePatient {
    override fun dischargePatient(patientDischarge: DischargePatientDto): Boolean {
        return divisionFacade.dischargePatient(patientDischarge)
    }

    override fun printDischargeInformation(patientId: UUID): String {
        TODO("Not yet implemented")
    }
}