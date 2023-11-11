package group26_HMS.pms.domain.divisionManagement.entities

import group26_HMS.pms.domain.patientManagement.entities.Patient
import java.util.UUID

class Division(
    val id: String,
    var name: String,
    var chargeNurseId: UUID,
    var location: String,
    var totalBeds: Number,
    var phoneExt:Number,
    var status: String? = "incomplete"
) {
    private var availableBeds:MutableList<Number> = mutableListOf()
    private var admissions:MutableList<PatientAdmission> = mutableListOf()
    private var pendingAdmissionRequests:MutableList<AdmissionRequest> = mutableListOf()

    fun isComplete():Boolean {
        return status.equals("complete")
    }

    fun updateFromAdmission(admission:PatientAdmission):Boolean {
        availableBeds.remove(admission.bedNumber)
        admissions.add(admission)
        if (availableBeds.size==totalBeds) {
            status = "complete"
        }
        return true
    }

    fun updateFromDischarge(admission:PatientAdmission):Boolean {
        availableBeds.add(admission.bedNumber)
        admissions.remove(admission)
        if (status.equals("complete")) {
            status = "incomplete"
        }
        return true;
    }

    fun bedIsAvailable(bedNumber: Number):Boolean {
        return availableBeds.contains(bedNumber)
    }
}