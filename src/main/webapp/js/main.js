$(document).ready(function () {

  var tableContainer = $('#MyTableContainer');
  tableContainer.jtable({
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
        title: 'Name'
      },
      department: {
        title: 'Department',
        options: {
          'PROMOTIONS': 'Promotions',
          'ADMINISTRATION': 'Administration',
          'ENGINEERING': 'Engineering',
          'SALES': 'Sales',
          'TRANSPORT': 'Transport'
        }
      },
      address: {
        title: 'Address'
      },
      mobile: {
        title: 'Mobile'
      },
      email: {
        title: 'Email'
      }
    }
  });

  //Load student list from server
  tableContainer.jtable('load');
});