package group26_HMS.pms.contracts.testStubs.factories

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.PatientAdmissionFromRequestListDto
import group26_HMS.pms.domain.divisionManagement.entities.AdmissionRequest
import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import group26_HMS.pms.domain.divisionManagement.factories.AdmissionFactory

class AdmissionFactoryStub:AdmissionFactory {
    override fun createAdmission(admitInfo: AdmitPatientDto): PatientAdmission {
        TODO("Not yet implemented")
    }

    override fun createAdmissionRequest(requestInfo: PatientAdmissionFromRequestListDto): AdmissionRequest {
        TODO("Not yet implemented")
    }
}