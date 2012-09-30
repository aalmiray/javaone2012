package addressbook

import groovy.beans.Bindable
import ca.odell.glazedlists.*

@Bindable
class AddressbookModel {
    String name
    String lastname
    String address
    String company
    String email

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