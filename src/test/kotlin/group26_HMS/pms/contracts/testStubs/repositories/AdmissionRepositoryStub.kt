package group26_HMS.pms.contracts.testStubs.repositories

import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import group26_HMS.pms.domain.divisionManagement.repositories.AdmissionRepository
import java.util.*

class AdmissionRepositoryStub:AdmissionRepository {
    private val admissions: MutableMap<String, PatientAdmission> = HashMap()

    override fun find(patientId: UUID): PatientAdmission? {
        TODO("Not yet implemented")
    }

    override fun save(admission: PatientAdmission): PatientAdmission {
        TODO("Not yet implemented")
    }
}