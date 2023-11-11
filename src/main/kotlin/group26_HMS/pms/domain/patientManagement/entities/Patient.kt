package group26_HMS.pms.domain.patientManagement.entities

import java.time.LocalDate
import java.util.UUID

class Patient (
    val id:UUID,
    var firstName:String,
    var lastName:String,
    var insuranceNum: Number,
    var address: Address,
    var email:String,
    var phoneNumber:String,
    var dateOfBirth: LocalDate,
    var gender: String,
    var maritalStatus: String,
    var externalDoctor: String,
    var nextOfKin: PatientKin,
    //added to check between nuse and patient divison 
    var divisionId: String? = null,
    var prescriptions:MutableList<UUID>? = mutableListOf<UUID>(),
){
    fun update(updated: Patient) {
        firstName = updated.firstName
        lastName = updated.lastName
        insuranceNum = updated.insuranceNum
        address = updated.address
        email = updated.email
        phoneNumber = updated.phoneNumber
        dateOfBirth = updated.dateOfBirth
        gender = updated.gender
        maritalStatus = updated.maritalStatus
        externalDoctor = updated.externalDoctor
        nextOfKin = updated.nextOfKin
        if (prescriptions!=null) {
            prescriptions = updated.prescriptions
        }
    }
    fun addPrescription(prescriptionId: UUID){
        prescriptions?.add(prescriptionId)
    }
}