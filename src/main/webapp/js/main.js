$(document).ready(function () {

  $('#MyTableContainer').jtable({
    title: 'The Customer List',
    paging: true, //Enable paging
    pageSize: 10, //Set page size (default: 10)
    sorting: true, //Enable sorting
    defaultSorting: 'name ASC', //Set default sorting
    ajaxSettings: {
      type: 'GET',
      dataType: 'json'
    },
    actions: {
      listAction: '/mycrm/getAllCustomers',
      deleteAction: '/mycrm/deleteCustomer',
      updateAction: '/mycrm/updateCustomer',
      createAction: '/mycrm/addNewCustomer'
    },
    fields: {
      id: {
        title: "ID",
        key: true,
        create: false,
        edit: false
      },
      name: {
        title: 'Name',
        width: '23%'
      },
      department: {
        title: 'Deparment'
      }
    }
  });

  //Load student list from server
  $('#MyTableContainer').jtable('load');
});