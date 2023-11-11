
package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.MedicationPerscriptionDto
import group26_HMS.pms.application.usecases.PrescribeMedication
import group26_HMS.pms.domain.prescriptionManagement.facade.PerscriptionFacade
import java.util.*


class PerscribeMedicationImpl(
    private var perscriptionFacade: PerscriptionFacade): PrescribeMedication{
    override fun prescribeMedication(perscriptionInfo: MedicationPerscriptionDto): Boolean {
        return perscriptionFacade.createPerscription(perscriptionInfo)
    }
}