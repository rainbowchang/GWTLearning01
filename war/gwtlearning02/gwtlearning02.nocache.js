function gwtlearning02(){var O='bootstrap',P='begin',Q='gwt.codesvr.gwtlearning02=',R='gwt.codesvr=',S='gwtlearning02',T='startup',U='DUMMY',V=0,W=1,X='iframe',Y='javascript:""',Z='position:absolute; width:0; height:0; border:none; left: -1000px;',$=' top: -1000px;',_='CSS1Compat',ab='<!doctype html>',bb='',cb='<html><head><\/head><body><\/body><\/html>',db='undefined',eb='DOMContentLoaded',fb=50,gb='Chrome',hb='eval("',ib='");',jb='script',kb='javascript',lb='moduleStartup',mb='moduleRequested',nb='Failed to load ',ob='head',pb='meta',qb='name',rb='gwtlearning02::',sb='::',tb='gwt:property',ub='content',vb='=',wb='gwt:onPropertyErrorFn',xb='Bad handler "',yb='" for "gwt:onPropertyErrorFn"',zb='gwt:onLoadErrorFn',Ab='" for "gwt:onLoadErrorFn"',Bb='#',Cb='?',Db='/',Eb='img',Fb='clear.cache.gif',Gb='baseUrl',Hb='gwtlearning02.nocache.js',Ib='base',Jb='//',Kb='user.agent',Lb='webkit',Mb='safari',Nb='msie',Ob=10,Pb=11,Qb='ie10',Rb=9,Sb='ie9',Tb=8,Ub='ie8',Vb='gecko',Wb='gecko1_8',Xb=2,Yb=3,Zb=4,$b='selectingPermutation',_b='gwtlearning02.devmode.js',ac='15E2266EDB50066A4A83A554DB13AA49',bc='4ED064646FBD55672513359AB748007B',cc='630EF4F854039EC2C10C37AE8E811D6C',dc='6C4DC49FE0FBA033754963D6CE8D97BB',ec='8C10506FC9B3F4C3EB2C93375DA5CC01',fc=':',gc='.cache.js',hc='link',ic='rel',jc='stylesheet',kc='href',lc='loadExternalRefs',mc='gwt/clean/clean.css',nc='end',oc='http:',pc='file:',qc='_gwt_dummy_',rc='__gwtDevModeHook:gwtlearning02',sc='Ignoring non-whitelisted Dev Mode URL: ',tc=':moduleBase';var o=window;var p=document;r(O,P);function q(){var a=o.location.search;return a.indexOf(Q)!=-1||a.indexOf(R)!=-1}
function r(a,b){if(o.__gwtStatsEvent){o.__gwtStatsEvent({moduleName:S,sessionId:o.__gwtStatsSessionId,subSystem:T,evtGroup:a,millis:(new Date).getTime(),type:b})}}
gwtlearning02.__sendStats=r;gwtlearning02.__moduleName=S;gwtlearning02.__errFn=null;gwtlearning02.__moduleBase=U;gwtlearning02.__softPermutationId=V;gwtlearning02.__computePropValue=null;gwtlearning02.__getPropMap=null;gwtlearning02.__installRunAsyncCode=function(){};gwtlearning02.__gwtStartLoadingFragment=function(){return null};gwtlearning02.__gwt_isKnownPropertyValue=function(){return false};gwtlearning02.__gwt_getMetaProperty=function(){return null};var s=null;var t=o.__gwt_activeModules=o.__gwt_activeModules||{};t[S]={moduleName:S};gwtlearning02.__moduleStartupDone=function(e){var f=t[S].bindings;t[S].bindings=function(){var a=f?f():{};var b=e[gwtlearning02.__softPermutationId];for(var c=V;c<b.length;c++){var d=b[c];a[d[V]]=d[W]}return a}};var u;function v(){w();return u}
function w(){if(u){return}var a=p.createElement(X);a.src=Y;a.id=S;a.style.cssText=Z+$;a.tabIndex=-1;p.body.appendChild(a);u=a.contentDocument;if(!u){u=a.contentWindow.document}u.open();var b=document.compatMode==_?ab:bb;u.write(b+cb);u.close()}
function A(k){function l(a){function b(){if(typeof p.readyState==db){return typeof p.body!=db&&p.body!=null}return /loaded|complete/.test(p.readyState)}
var c=b();if(c){a();return}function d(){if(!c){c=true;a();if(p.removeEventListener){p.removeEventListener(eb,d,false)}if(e){clearInterval(e)}}}
if(p.addEventListener){p.addEventListener(eb,d,false)}var e=setInterval(function(){if(b()){d()}},fb)}
function m(c){function d(a,b){a.removeChild(b)}
var e=v();var f=e.body;var g;if(navigator.userAgent.indexOf(gb)>-1&&window.JSON){var h=e.createDocumentFragment();h.appendChild(e.createTextNode(hb));for(var i=V;i<c.length;i++){var j=window.JSON.stringify(c[i]);h.appendChild(e.createTextNode(j.substring(W,j.length-W)))}h.appendChild(e.createTextNode(ib));g=e.createElement(jb);g.language=kb;g.appendChild(h);f.appendChild(g);d(f,g)}else{for(var i=V;i<c.length;i++){g=e.createElement(jb);g.language=kb;g.text=c[i];f.appendChild(g);d(f,g)}}}
gwtlearning02.onScriptDownloaded=function(a){l(function(){m(a)})};r(lb,mb);var n=p.createElement(jb);n.src=k;if(gwtlearning02.__errFn){n.onerror=function(){gwtlearning02.__errFn(S,new Error(nb+code))}}p.getElementsByTagName(ob)[V].appendChild(n)}
gwtlearning02.__startLoadingFragment=function(a){return D(a)};gwtlearning02.__installRunAsyncCode=function(a){var b=v();var c=b.body;var d=b.createElement(jb);d.language=kb;d.text=a;c.appendChild(d);c.removeChild(d)};function B(){var c={};var d;var e;var f=p.getElementsByTagName(pb);for(var g=V,h=f.length;g<h;++g){var i=f[g],j=i.getAttribute(qb),k;if(j){j=j.replace(rb,bb);if(j.indexOf(sb)>=V){continue}if(j==tb){k=i.getAttribute(ub);if(k){var l,m=k.indexOf(vb);if(m>=V){j=k.substring(V,m);l=k.substring(m+W)}else{j=k;l=bb}c[j]=l}}else if(j==wb){k=i.getAttribute(ub);if(k){try{d=eval(k)}catch(a){alert(xb+k+yb)}}}else if(j==zb){k=i.getAttribute(ub);if(k){try{e=eval(k)}catch(a){alert(xb+k+Ab)}}}}}__gwt_getMetaProperty=function(a){var b=c[a];return b==null?null:b};s=d;gwtlearning02.__errFn=e}
function C(){function e(a){var b=a.lastIndexOf(Bb);if(b==-1){b=a.length}var c=a.indexOf(Cb);if(c==-1){c=a.length}var d=a.lastIndexOf(Db,Math.min(c,b));return d>=V?a.substring(V,d+W):bb}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=p.createElement(Eb);b.src=a+Fb;a=e(b.src)}return a}
function g(){var a=__gwt_getMetaProperty(Gb);if(a!=null){return a}return bb}
function h(){var a=p.getElementsByTagName(jb);for(var b=V;b<a.length;++b){if(a[b].src.indexOf(Hb)!=-1){return e(a[b].src)}}return bb}
function i(){var a=p.getElementsByTagName(Ib);if(a.length>V){return a[a.length-W].href}return bb}
function j(){var a=p.location;return a.href==a.protocol+Jb+a.host+a.pathname+a.search+a.hash}
var k=g();if(k==bb){k=h()}if(k==bb){k=i()}if(k==bb&&j()){k=e(p.location.href)}k=f(k);return k}
function D(a){if(a.match(/^\//)){return a}if(a.match(/^[a-zA-Z]+:\/\//)){return a}return gwtlearning02.__moduleBase+a}
function F(){var f=[];var g=V;function h(a,b){var c=f;for(var d=V,e=a.length-W;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
var i=[];var j=[];function k(a){var b=j[a](),c=i[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(s){s(a,d,b)}throw null}
j[Kb]=function(){var a=navigator.userAgent.toLowerCase();var b=p.documentMode;if(function(){return a.indexOf(Lb)!=-1}())return Mb;if(function(){return a.indexOf(Nb)!=-1&&(b>=Ob&&b<Pb)}())return Qb;if(function(){return a.indexOf(Nb)!=-1&&(b>=Rb&&b<Pb)}())return Sb;if(function(){return a.indexOf(Nb)!=-1&&(b>=Tb&&b<Pb)}())return Ub;if(function(){return a.indexOf(Vb)!=-1||b>=Pb}())return Wb;return bb};i[Kb]={gecko1_8:V,ie10:W,ie8:Xb,ie9:Yb,safari:Zb};__gwt_isKnownPropertyValue=function(a,b){return b in i[a]};gwtlearning02.__getPropMap=function(){var a={};for(var b in i){if(i.hasOwnProperty(b)){a[b]=k(b)}}return a};gwtlearning02.__computePropValue=k;o.__gwt_activeModules[S].bindings=gwtlearning02.__getPropMap;r(O,$b);if(q()){return D(_b)}var l;try{h([Mb],ac);h([Qb],bc);h([Wb],cc);h([Sb],dc);h([Ub],ec);l=f[k(Kb)];var m=l.indexOf(fc);if(m!=-1){g=parseInt(l.substring(m+W),Ob);l=l.substring(V,m)}}catch(a){}gwtlearning02.__softPermutationId=g;return D(l+gc)}
function G(){if(!o.__gwt_stylesLoaded){o.__gwt_stylesLoaded={}}function c(a){if(!__gwt_stylesLoaded[a]){var b=p.createElement(hc);b.setAttribute(ic,jc);b.setAttribute(kc,D(a));p.getElementsByTagName(ob)[V].appendChild(b);__gwt_stylesLoaded[a]=true}}
r(lc,P);c(mc);r(lc,nc)}
B();gwtlearning02.__moduleBase=C();t[S].moduleBase=gwtlearning02.__moduleBase;var H=F();if(o){var I=!!(o.location.protocol==oc||o.location.protocol==pc);o.__gwt_activeModules[S].canRedirect=I;function J(){var b=qc;try{o.sessionStorage.setItem(b,b);o.sessionStorage.removeItem(b);return true}catch(a){return false}}
if(I&&J()){var K=rc;var L=o.sessionStorage[K];if(!/^http:\/\/(localhost|127\.0\.0\.1)(:\d+)?\/.*$/.test(L)){if(L&&(window.console&&console.log)){console.log(sc+L)}L=bb}if(L&&!o[K]){o[K]=true;o[K+tc]=C();var M=p.createElement(jb);M.src=L;var N=p.getElementsByTagName(ob)[V];N.insertBefore(M,N.firstElementChild||N.children[V]);return false}}}G();r(O,nc);A(H);return true}
gwtlearning02.succeeded=gwtlearning02();