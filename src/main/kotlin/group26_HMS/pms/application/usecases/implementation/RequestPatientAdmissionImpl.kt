package group26_HMS.pms.application.usecases
import group26_HMS.pms.application.dtos.queries.PatientAdmissionFromRequestListDto
import group26_HMS.pms.domain.patientManagement.facade.PatientFacade
import java.util.UUID

class RequestPatientAdmissionImpl (
    private var patientFacade: PatientFacade): AdmitPatientFromRequestList {

    override fun admitPatientFromRequestList(admitPatient: PatientAdmissionFromRequestListDto): UUID {
        TODO("Not yet implemented")
    }

    override fun validatePatientInRequestList(patientId: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun denyPatientAdmission(chargeNurseId: UUID, patientId: UUID): Boolean {
        TODO("Not yet implemented")
    }
}

