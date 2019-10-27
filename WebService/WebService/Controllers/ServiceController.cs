using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WebService.Controllers
{
    public class ServiceController : ApiController
    {
        [HttpGet]
        public jsonParam get5Param(string input1, string input2, string input3, string input4, string input5)
        {
            int iValue1 = Convert.ToInt32(input1);
            int iValue2 = Convert.ToInt32(input2);
            int iValue3 = Convert.ToInt32(input3);
            int iValue4 = Convert.ToInt32(input4);
            int iValue5 = Convert.ToInt32(input5);

            jsonParam js = new jsonParam();

            int Sum = (iValue1 + iValue2 + iValue3 + iValue4 + iValue5);

            js.sum = Sum.ToString();
            js.mean = ((float)Sum / (float)5).ToString();

            return js;

        }

        
        [HttpGet]
        public Result getWithoutParam()
        {
            Result rs = new Result();
            rs.res = "No parametre";
            return rs;
        }

        [HttpGet]

        public standartS std(string sum, string mean)
        {
            double standartsapma =(double)( Convert.ToDouble(sum) / Convert.ToDouble(mean));

            standartS st = new standartS();
            st.std = standartsapma.ToString();

            return st;

        }

        [HttpPost]
        [Route("api/Service/PostMethod")]
        public resPost PostMethod([FromBody] inputValue iv)
        {
            int iValue = Convert.ToInt32(iv.value);
            resPost rp = new resPost();
            rp.square = (iValue * iValue).ToString();
            return rp;
        }
    }

    public class inputValue{
        public string value {get;set;}
    }

    public class resPost
    {
        public string square { get; set; }
    }
    public class jsonParam
    {
        public string sum { get; set; }
        public string mean { get; set; }
    }

    public class standartS
    {
        public string std { get; set; }
    }

    public class Result
    {
        public string res { get; set; }
    }

}
