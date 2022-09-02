"use strict"

$(document).ready(function () {
    loadContacts();
})

function loadContacts() {
    $(function () {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/contact/',
            cache: false,
        }).done(function (contacts) {
            for (const contact of contacts) {
                insertContact(contact);
            }
        }).fail(function (err) {
            console.log(err);
        });
    })
}

function saveContact() {
    let contactName = document.getElementById("contactNameId").value;
    let contactNumber = document.getElementById("contactNumberId").value;
    let contact = {name : contactName, number : contactNumber};

    $(function () {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/contact/',
            data: JSON.stringify(contact),
            cache: false,
            dataType: 'json',
            contentType: "application/json"
        }).done(function (contact) {
            insertContact(contact);
        }).fail(function (err) {
            console.log(err);
        });
    })
}

function insertContact(contact) {
    $('#contactsTable tbody').append('<tr>'
        + '<td id="nameRow'+ contact.id +'">' + contact.name + '</td>'
        + '<td id="numberRow'+ contact.id +'">' + contact.number + '</td>'
        + '<td>' + contact.created + '</td>'
        + '<td>' + '<input type="button" id="edit' + contact.id + '" value="редактировать">' + '</td>'
        + '<td>' + '<input type="button" id="delete' + contact.id + '" value="удалить" onclick="deleteContact(' + contact.id + ')">' + '</td>')
        .append('<div id="modal' + contact.id + '" class="modal">\n' +
            '\n' +
            '            <div class="modal-content">\n' +
            '                <input type="text" id="editName' + contact.id + '" value="' + contact.name + '" placeholder="Введите новое имя">\n' +
            '                <input type="text" id="editNumber' + contact.id + '" value="' + contact.number + '" placeholder="Введите новый телефон">\n' +
            '                <input type="button" id="editButton'+ contact.id +'" value="Редактировать контакт" onclick="updateContact('+ contact.id +')"> \n' +
            '                <input type="button" id="cancelButton'+ contact.id +'" value="Отмена" onclick="cancelUpdate('+ contact.id +')"> \n' +
            '            </div>\n' +
            '\n' +
            '        </div>');

    const modal = document.getElementById('modal' + contact.id);
    const btn = document.getElementById('edit' + contact.id);
    btn.onclick = function() {
        modal.style.display = "block";
    }
}

function updateContact(contactId) {
    const contactName = document.getElementById('editName' + contactId).value;
    const contactNumber = document.getElementById('editNumber' + contactId).value;
    let contact = {id:contactId, name : contactName, number : contactNumber};
    $(function () {
        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/contact/',
            data: JSON.stringify(contact),
            cache: false,
            contentType: "application/json"
        }).done(function () {
            document.getElementById('nameRow' + contactId).innerHTML = contactName;
            document.getElementById('numberRow' + contactId).innerHTML = contactNumber;
        }).fail(function (err) {
            console.log(err);
        });
    })
    const modal = document.getElementById('modal' + contactId);
    modal.style.display = "none";
}

function cancelUpdate(contactId) {
    const modal = document.getElementById('modal' + contactId);
    modal.style.display = "none";

}

function deleteContact(id) {
    $(function () {
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/contact/' + id,
            cache: false,
        }).done(function () {
            const rowToDelete = document.getElementById("delete" + id).parentNode.parentNode.rowIndex;
            document.getElementById('contactsTable').deleteRow(rowToDelete);
        }).fail(function (err) {
            console.log(err);
        });
    })
}