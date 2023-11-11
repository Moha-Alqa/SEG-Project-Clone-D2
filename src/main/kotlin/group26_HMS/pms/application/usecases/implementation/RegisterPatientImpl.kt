package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import group26_HMS.pms.application.usecases.RegisterPatient
import group26_HMS.pms.domain.patientManagement.facade.PatientFacade
import java.util.*

class RegisterPatientImpl (
    private var patientFacade: PatientFacade): RegisterPatient {
    override fun addPatient(patientInfo: CreatePatientDto): UUID {
        val patientId = patientFacade.createPatient(patientInfo)
        return patientId
    }

    override fun checkStaffLoggedIn(staffID: UUID): Boolean {
        TODO("Not yet implemented")
    }
}