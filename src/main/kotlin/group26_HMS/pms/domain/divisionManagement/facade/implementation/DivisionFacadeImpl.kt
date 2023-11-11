package group26_HMS.pms.domain.divisionManagement.facade.implementation

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.DischargePatientDto
import group26_HMS.pms.application.services.DomainEventEmitter
import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import group26_HMS.pms.domain.divisionManagement.events.DischargedPatientFromDivision
import group26_HMS.pms.domain.divisionManagement.events.NewAdmissionToDivision
import group26_HMS.pms.domain.divisionManagement.facade.DivisionFacade
import group26_HMS.pms.domain.divisionManagement.factories.AdmissionFactory
import group26_HMS.pms.domain.divisionManagement.repositories.AdmissionRepository
import group26_HMS.pms.domain.divisionManagement.repositories.DivisionRepository
import java.util.Date
import java.util.UUID

class DivisionFacadeImpl(
    private var admissionFactory:AdmissionFactory,
    private var admissionRepository: AdmissionRepository,
    private var divisionRepository: DivisionRepository,
    private var eventEmitter: DomainEventEmitter):DivisionFacade {

    override fun admitPatient(admitInfo: AdmitPatientDto): UUID? {
        val admission = admissionFactory.createAdmission(admitInfo)
        val division = divisionRepository.find(admitInfo.division)

        if (division!=null && division.bedIsAvailable(admitInfo.bedNumber)) {
            admissionRepository.save(admission)
            division.updateFromAdmission(admission)
            divisionRepository.save(division)
            eventEmitter.emit(NewAdmissionToDivision(
                UUID.randomUUID(),
                Date(),
                division.id,
                admitInfo.patientId.toString(),
                admission.id.toString()
            ))
            return admission.id
        }
        return null
    }

    override fun divisionIsAvailable(divisionId: String): Boolean {
        val division = divisionRepository.find(divisionId)
        if (division!=null) {
            return !division.isComplete()
        }
        return false
    }

    override fun dischargePatient(dischargeInfo: DischargePatientDto): Boolean {
        val admission = admissionRepository.find(dischargeInfo.patientId)
        val division = divisionRepository.find(dischargeInfo.division)

        if (admission!=null && division!=null) {
            division.updateFromDischarge(admission)
            divisionRepository.save(division)
            admission.discharge()
            admissionRepository.save(admission)
            eventEmitter.emit(DischargedPatientFromDivision(
                UUID.randomUUID(),
                Date(),
                division.id,
                dischargeInfo.patientId.toString(),
                admission.id.toString()
            ))
            return true
        }
        return false
    }
}