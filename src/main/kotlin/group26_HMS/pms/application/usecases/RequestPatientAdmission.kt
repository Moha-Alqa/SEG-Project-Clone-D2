package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import java.util.UUID

interface RequestPatientAdmission {
    fun requestPatientAdmission(patientAdmissionRequest: PatientAdmissionRequestDto): UUID
    fun validateAdmissionInfo(chargeNurseId: UUID, patientId: UUID, division: UUID): Boolean
    fun checkPatientAlreadyAdmitted(patientId: UUID, division: UUID): Boolean
}
