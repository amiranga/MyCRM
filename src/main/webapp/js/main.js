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
    },
    messages: {
      serverCommunicationError: 'An error occurred while communicating to the server.',
      loadingMessage: 'Loading customer list...',
      noDataAvailable: 'No data available!',
      addNewRecord: 'Add new customer',
      editRecord: 'Edit customer',
      deleteConfirmation: 'This customer record will be deleted. Are you sure?'
    },
    jqueryuiTheme: true
  });

  //Load student list from server
  tableContainer.jtable('load');
});