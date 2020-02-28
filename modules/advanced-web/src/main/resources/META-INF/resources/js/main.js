// Set here your portlet name space.
// var nameSpace = <PORLET_NAME_SPACE> ;
var nameSpace = '_fr_smile_training_web_portlet_AdvancedWebPortlet_';

/**
 * Add education if not existing in database
 */
function addEducation() {
    console.log("Executing addEducation method");

    AUI().use('aui-base', 'aui-io-request', function(A) {
        //get add education url
        var addEducationURL = A.one('#addEducationURL').get('text');

        //new education value
        var eduName = A.one('#'+nameSpace + 'education').get('value');

        if (eduName.trim() == '') {
            console.log("Blank value for education" + eduName);
            return;
        }

        //add education name as paramter
        addEducationURL = addEducationURL + "&"+nameSpace + "name="+eduName;

        //call ajax method for adding education value
        A.io.request(addEducationURL, {
            dataType: 'json',
            method: 'POST',
            sync: true,
            on: {
                success: function() {
                    console.log("Enter in success");
                    alert(JSON.stringify(this.get('responseData')));
                }
            }
        });
    });
}