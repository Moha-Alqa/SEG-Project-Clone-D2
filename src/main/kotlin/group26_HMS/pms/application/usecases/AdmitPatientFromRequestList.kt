package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.PatientAdmissionFromRequestListDto
import java.util.UUID

interface AdmitPatientFromRequestList {
    fun admitPatientFromRequestList(admitPatient: PatientAdmissionFromRequestListDto): UUID
    fun validatePatientInRequestList(patientId: UUID): Boolean
    fun denyPatientAdmission(chargeNurseId: UUID, patientId: UUID): Boolean
}
