package addressbook

import java.awt.event.ActionEvent
import griffon.transform.Threading

class AddressbookController {
    def model
    def view

    @Threading(Threading.Policy.SKIP)
    def newAction = {
        view.contactList.clearSelection()
        model.selectedIndex = -1
    }

    def saveAction = { 
        boolean isNew = model.selectedIndex == -1
        Contact contact = isNew ? new Contact() : model.contacts[model.selectedIndex]
        for (propName in Contact.PROPERTIES) {
            contact[propName] = model[propName]
        }
        if (isNew) {
            execInsideUIAsync {
                model.contacts << contact
                contact.id = model.contacts.size()
                view.contactList.selectedIndex = contact.id - 1
            }
        } else {
            view.contactList.repaint()
        }
    }

    @Threading(Threading.Policy.SKIP)
    def deleteAction = {
        if (model.selectedIndex > -1) {
            int index = model.selectedIndex
            model.selectedIndex = -1
            view.contactList.clearSelection()
            model.contacts.remove(index)
        }
    }

    void dumpAction(ActionEvent evt) {
        model.contacts.each { println it }
    }
}
