package group26_HMS.pms.domain.divisionManagement.facade

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.DischargePatientDto
import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import java.util.UUID

interface DivisionFacade {
    fun admitPatient(admitInfo:AdmitPatientDto): UUID?
    fun divisionIsAvailable(divisionId:String): Boolean
    fun dischargePatient(dischargeInfo:DischargePatientDto): Boolean
}