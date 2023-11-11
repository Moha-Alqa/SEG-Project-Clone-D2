package group26_HMS.pms.contracts.testStubs.repositories

import group26_HMS.pms.domain.divisionManagement.entities.Division
import group26_HMS.pms.domain.divisionManagement.repositories.DivisionRepository

class DivisionRepositoryStub:DivisionRepository {
    private val divisions: MutableMap<String,Division> = HashMap()

    override fun find(divisionId: String): Division? {
        TODO("Not yet implemented")
    }

    override fun save(division: Division): Division {
        TODO("Not yet implemented")
    }
}