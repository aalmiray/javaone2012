package addressbook

import groovy.beans.Bindable

@Bindable
class AddressbookModel {
    String name
    String lastname
    String address
    String company
    String email
}