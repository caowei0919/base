(window.webpackJsonp=window.webpackJsonp||[]).push([[4],{"1d16":function(t,e,a){"use strict";a.r(e);var o=a("8bbe").a,n=(a("6d84"),a("2877")),r=Object(n.a)(o,(function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"view"},[this.showAll?e("div",{staticClass:"container"},[e("drawComponent",{ref:"draw",attrs:{model:"view"}})],1):this._e(),e("modal",{attrs:{properties:this.popupWindowOpt},on:{afterClickButton:this.changePopupWindowClick}},[e("div",{style:{width:"100%",height:"100%"},attrs:{slot:"windowBody"},slot:"windowBody"},[e("iframe",{style:{width:"100%",height:"100%"},attrs:{src:this.modalClick.iframeSrc,frameborder:"0"}})])])],1)}),[],!1,null,"0176827c",null);e.default=r.exports},"3ce4":function(t,e,a){"use strict";var o=a("cc56").a,n=(a("ddd5"),a("2877")),r=Object(n.a)(o,(function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loadingLinear",rawName:"v-loadingLinear",value:{show:t.loadingState},expression:"{ show: loadingState }"}],style:t.padStyle},t._l(t.pageList,(function(e){return a("div",{key:"draw-"+e,staticClass:"pageBox",style:t.pageBoxSize},[a("div",{staticClass:"page",class:{overHide:"view"===t.model},style:t.transformPageStyle[e],attrs:{editRole:e}},[a("div",{staticClass:"graticule"},t._l(t.drawBlockContent[e],(function(e){return a("div",{directives:[{name:"show",rawName:"v-show",value:t.showBolckArea(e),expression:"showBolckArea(item)"}],key:e.id,staticClass:"bolckArea",class:{selected:e.selected},style:e.position,attrs:{editRole:"bolck",name:e.id}},[a("div",{key:"draw-"+e.id,staticClass:"blockContent",attrs:{editRole:"content"}},[a(("bar"===e.type?"line":e.type)+"Component",{tag:"component",attrs:{blockType:e.type,model:t.model,getData:e.contentData,getStyle:e.position,blockId:e.id,reportSetting:t.reportStyle.blockStyle,theme:t.reportSetting.echartsTheme,toggleData:t.dataForToggleType[e.id],params:t.paramToBlock}})],1)])})),0)])])})),0)}),[],!1,null,"2c6ac66c",null);e.a=r.exports},"3f41":function(t,e,a){},"6d84":function(t,e,a){"use strict";var o=a("fe96");a.n(o).a},"8bbe":function(t,e,a){"use strict";(function(t){var o=a("5530"),n=a("3ce4"),r=a("2f62");e.a={name:"viewapp",data:function(){return{modelId:"",urls:{openReport:"/report"},showAll:!1,metaMode:"pc"}},components:{drawComponent:n.a},computed:Object(o.a)({},Object(r.d)({popupWindowOpt:function(t){return t.popupWindowOpt},popupWindowClick:function(t){return t.popupWindowClick},paramToBlock:function(t){return t.reportParam.paramSelectValue},modalClick:function(t){return t.modalClick}})),watch:{popupWindowClick:function(){switch(this.popupWindowUser){case"initLoad":this.hidePopupWindow()}},popupWindowOpt:function(){!this.popupWindowOpt.show&&this.popupWindowUser&&(this.popupWindowUser="")}},mounted:function(){var e=this;if(e.showAll=!0,window.setParam=function(t){e.setParam(t)},window.onresize=function(){e.$refs.draw.setParentWidth()},this.$route.params.id){this.modelId=this.$route.params.id;var a={resId:this.modelId,type:"view"};this.drawChangeBlockLoadingState({name:"view",loadState:"start"}),this.$http({url:this.urls.openReport,params:a,method:"get"}).then((function(a){if(t.isEmptyObject(a.data)){var o={show:!0,type:"alert",content:e.$t("design.designNoData")};e.popupWindowUser="initLoad",e.showPopupWindow(o)}else{a.data=a.data.data;var n=a.data.init_params.content;n.draw.reportSetting.app?e.metaMode="app":n.draw.reportSetting.app||(e.metaMode="pc"),e.setParam(e.$route.query),e.controllerRestoreData(n.pageController),e.drawRestoreData(n.draw)}e.drawChangeBlockLoadingState({name:"view",loadState:"finish"})})).catch((function(t){e.drawChangeBlockLoadingState({name:"view",loadState:"error"});var a=e.$t("design.designGetDataFailed");t&&t.response&&t.response.data&&(a=t.response.data.message);var o={show:!0,type:"alert",content:a,style:{height:"120px"}};e.popupWindowUser="initLoad",e.showPopupWindow(o)}))}},methods:Object(o.a)(Object(o.a)({},Object(r.b)({drawRestoreData:"drawRestoreData",drawChangeBlockLoadingState:"drawChangeBlockLoadingState",controllerRestoreData:"controllerRestoreData",showPopupWindow:"showPopupWindow",hidePopupWindow:"hidePopupWindow",changePopupWindowClick:"changePopupWindowClick",restoreReportParam:"restoreReportParam",changeReportParamSelectValue:"changeReportParamSelectValue"})),{},{setParam:function(t){this.changeReportParamSelectValue(t)}})}}).call(this,a("1157"))},cc56:function(t,e,a){"use strict";(function(t){a("99af"),a("4160"),a("159b"),a("cca6");var o=a("5530"),n=a("0aad"),r=a("5fd9"),i=a("dd9a"),s=a("6172"),p=a("2883"),c=a("ec8a"),d=a("43e9"),l=a("1e94"),u=a("209c"),h=a("3418"),g=a("02c3"),w=a("14a6"),m=a("be1e"),f=a("b805"),S=a("bdfb"),C=a("7739"),v=a("cc61"),b=a("4061"),k=a("23aa"),y=a("2f62");a("006f");e.a={name:"draw-app",props:["model"],components:{lineComponent:n.a,pieComponent:i.a,radarComponent:s.a,tableComponent:m.a,treeComponent:f.a,textComponent:S.a,imageComponent:r.a,rectangleComponent:h.a,roundComponent:g.a,otherShapesComponent:w.a,dataobjComponent:C.a,moreComponent:v.a,dropdownComponent:b.a,reportWidgetComponent:k.a,crossBarComponent:p.a,funnelComponent:c.a,gaugeComponent:d.a,mapComponent:l.a,map3DComponent:u.a},data:function(){return{parentWidth:0,parentHeight:0,scale:1,scaleY:1,defaultData:{minLeft:30,minTop:10,defaultBlockWidth:200,defaultBlockHeight:150,minMoveDistance:10},drawGroups:{},drawGroupCarouselInterval:{},isInit:!0}},computed:Object(o.a)(Object(o.a)({showBolckArea:function(){var t=this;return function(e){return e.contentData.groupSetting&&e.contentData.groupSetting.isCarousel?e.contentData.groupSetting.currentIndex===e.contentData.groupSetting.index:"edit"===t.model||(void 0===e.contentData.show||e.contentData.show)}},pageSize:function(){var t=this.reportSetting.fullScreen?this.parentWidth/parseFloat(this.drawSize.width):1,e=this.reportSetting.fullScreen?this.parentHeight/parseFloat(this.drawSize.height):1;return this.scale=t,this.scaleY=e,{width:this.drawSize.width,height:this.drawSize.height,transform:"scale(".concat(t,", ").concat(e,")"),"transform-origin":"0px 0px 0px"}},pageBoxSize:function(){var t=this.reportSetting.fullScreen?this.parentWidth/parseFloat(this.drawSize.width):1,e=this.reportSetting.fullScreen?this.parentHeight/parseFloat(this.drawSize.height):1;return this.scale=t,{width:parseFloat(this.drawSize.width)*t+"px",height:parseFloat(this.drawSize.height)*e+"px"}},drawBlockContent:function(){var e=t.extend(!0,{},this.blockContent);for(var a in e){this.drawGroups[a]?this._.forEach(this.drawGroups[a],(function(t){t.count=0})):this.drawGroups[a]={};for(var o=0;o<this.pageContent[a].length;o++){var n=this.pageContent[a][o];e[a][n].position.scale=this.scale>0?this.scale:1,e[a][n].position["z-index"]=o,e[a][n].contentData.groupSetting&&e[a][n].contentData.groupSetting.isCarousel&&(this.drawGroups[a][e[a][n].group]||(this.drawGroups[a][e[a][n].group]={currentIndex:1,count:0}),e[a][n].contentData.groupSetting.currentIndex=e[a][n].contentData.groupSetting.currentIndex||1,this.drawGroups[a][e[a][n].group].count=this.drawGroups[a][e[a][n].group].count+1,e[a][n].contentData.groupSetting.index=this.drawGroups[a][e[a][n].group].count)}}return e},transformPageStyle:function(){var e={};for(var a in this.blockContent){var o=Object.assign({position:"relative"},this.reportStyle.pageStyle,this.pageStyle[a],this.pageSize);e[a]=o}for(var n in e)e[n].backgroundPosition=e[n].backgroundPositionX+" "+e[n].backgroundPositionY,delete e[n].backgroundPositionX,delete e[n].backgroundPositionY,e[n].backgroundImage&&!t.isEmptyObject(e[n].backgroundImage)&&(e[n].backgroundImage="url("+(e[n].backgroundImage.isLocal?this.$projectName:"")+e[n].backgroundImage.url+")");return e},padStyle:function(){return{position:"relative",width:"100%",height:"100vh",backgroundColor:this.reportStyle.pageStyle.backgroundColor,cursor:"default"}}},Object(y.d)({drawSize:function(t){return t.draw.drawSize},reportStyle:function(t){return t.draw.reportStyle},pageStyle:function(t){return t.draw.pageStyle},blockContent:function(t){return t.draw.blockContent},refreshWidth:function(t){return t.draw.refreshWidth},reportSetting:function(t){return t.draw.reportSetting},pageContent:function(t){return t.draw.pageContent},dataForToggleType:function(t){return t.draw.dataForToggleType},pageList:function(t){return t.pageController.pageList},paramToBlock:function(t){return t.reportParam.paramSelectValue}})),Object(y.c)({loadingState:"loadingState",groupData:"groupData"})),watch:{refreshWidth:function(){this.setParentWidth()},groupData:function(){this.isInit&&"view"===this.model&&(this.startAutoCarousel(),this.isInit=!1)}},methods:Object(o.a)(Object(o.a)({},Object(y.b)({drawChangeSpecialDatas:"drawChangeSpecialDatas"})),{},{setParentWidth:function(){this.parentWidth=this.$el.parentNode.clientWidth,this.parentHeight=this.$el.parentNode.clientHeight},startAutoCarousel:function(){var t=this;t._.forEach(t.groupData,(function(e,a){t._.forEach(e,(function(e,o){if(e.setting&&e.setting.isCarousel){var n=0;clearInterval(t.drawGroupCarouselInterval[o]),t.drawGroupCarouselInterval[o]=setInterval((function(){(n=t.drawGroups[a][o].currentIndex+1)===t.drawGroups[a][o].count+1&&(n=1),t.drawGroups[a][o].currentIndex=n;var r={};t._.forEach(e.children,(function(t){r[t]={groupSetting:{currentIndex:n}}})),t.drawChangeSpecialDatas(r)}),e.setting.carouselTime)}}))}))}}),mounted:function(){this.setParentWidth()}}}).call(this,a("1157"))},ddd5:function(t,e,a){"use strict";var o=a("3f41");a.n(o).a},fe96:function(t,e,a){}}]);