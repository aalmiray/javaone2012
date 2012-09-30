package addressbook

import groovy.beans.Bindable
import ca.odell.glazedlists.*
import griffon.transform.PropertyListener

@Bindable
class AddressbookModel {
    String name
    String lastname
    String address
    String company
    String email

    @PropertyListener(selectionUpdater)
    int selectedIndex = -1

    private selectionUpdater = { e ->
        Contact selectedContact = selectedIndex != -1 ? contacts[selectedIndex] : null
        for (propName in Contact.PROPERTIES) {
            this[propName] = selectedContact ? selectedContact[propName] : ''
        }
    }

    final EventList<Contact> contacts = GlazedLists.threadSafeList(new BasicEventList<Contact>())

    AddressbookModel() {
        contacts << new Contact(
            id: 1,
            name: 'Andres',
            lastname: 'Almiray',
            address: 'Kirschgartenstrasse 5 CH-4051 Switzerland',
            company: 'Canno Engineering AG',
            email: 'andres.almiray@canoo.com'
        )
    }
}