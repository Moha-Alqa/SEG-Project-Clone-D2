package group26_HMS.pms.application.dtos.queries

import java.time.LocalDateTime
import java.util.UUID

data class PatientAdmissionRequestDto(
    val chargeNurseId: UUID,
    val patientId: UUID,
    val division: UUID,
    val rationale: String,
    val priority: Number,
    val localDoctor: UUID,
    val requestDate: LocalDateTime
)
