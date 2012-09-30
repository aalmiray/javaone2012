package addressbook

import java.awt.event.ActionEvent

class AddressbookController {
    def model

    def newAction = {
        println 'New'
    }

    def saveAction = {
        println 'Save'
    }

    def deleteAction = {
        println 'Delete'
    }

    void dumpAction(ActionEvent evt) {
        println 'Dump'
    }
}
