var setting = {
    data: {
        simpleData: {
            enable: true
        }
    }
};
/*
var zNodes =[
    { id:1, pId:0, name:"父节点1 - 展开", open:true},
    { id:11, pId:1, name:"父节点11 - 折叠"},
    { id:111, pId:11, name:"叶子节点111"},
    { id:112, pId:11, name:"叶子节点112"},
    { id:113, pId:11, name:"叶子节点113"},
    { id:114, pId:11, name:"叶子节点114"},
    { id:12, pId:1, name:"父节点12 - 折叠"},
    { id:121, pId:12, name:"叶子节点121"},
    { id:122, pId:12, name:"叶子节点122"},
    { id:123, pId:12, name:"叶子节点123"},
    { id:124, pId:12, name:"叶子节点124"},
    { id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true},
    { id:2, pId:0, name:"父节点2 - 折叠"},
    { id:21, pId:2, name:"父节点21 - 展开", open:true},
    { id:211, pId:21, name:"叶子节点211"},
    { id:212, pId:21, name:"叶子节点212"},
    { id:213, pId:21, name:"叶子节点213"},
    { id:214, pId:21, name:"叶子节点214"},
    { id:22, pId:2, name:"父节点22 - 折叠"},
    { id:221, pId:22, name:"叶子节点221"},
    { id:222, pId:22, name:"叶子节点222"},
    { id:223, pId:22, name:"叶子节点223"},
    { id:224, pId:22, name:"叶子节点224"},
    { id:23, pId:2, name:"父节点23 - 折叠"},
    { id:231, pId:23, name:"叶子节点231"},
    { id:232, pId:23, name:"叶子节点232"},
    { id:233, pId:23, name:"叶子节点233"},
    { id:234, pId:23, name:"叶子节点234"},
    { id:3, pId:0, name:"父节点3 - 没有子节点", isParent:true}
];
*/
var zNodes = [
    {
        "children": [
            {
                "children": [
                    {
                        "children": [
                            {
                                "children": [],
                                "id": 21100,
                                "name": "北京分公司-海淀支行-知春路店",
                                "parentId": 21000
                            },
                            {
                                "children": [],
                                "id": 21200,
                                "name": "北京分公司-海淀支行-中关村店",
                                "parentId": 21000
                            }
                        ],
                        "id": 21000,
                        "name": "北京分公司-海淀支行",
                        "parentId": 20000
                    },
                    {
                        "children": [],
                        "id": 22000,
                        "name": "北京分公司-朝阳支行",
                        "parentId": 20000
                    },
                    {
                        "children": [
                            {
                                "children": [
                                    {
                                        "children": [],
                                        "id": 23110,
                                        "name": "北京分公司-大兴支行-清源路店1店",
                                        "parentId": 23100
                                    },
                                    {
                                        "children": [],
                                        "id": 23120,
                                        "name": "北京分公司-大兴支行-清源路店2店",
                                        "parentId": 23100
                                    },
                                    {
                                        "children": [],
                                        "id": 23130,
                                        "name": "北京分公司-大兴支行-清源路店3店",
                                        "parentId": 23100
                                    }
                                ],
                                "id": 23100,
                                "name": "北京分公司-大兴支行-清源路分店",
                                "parentId": 23000
                            },
                            {
                                "children": [
                                    {
                                        "children": [],
                                        "id": 23210,
                                        "name": "北京分公司-大兴支行-黄村西大街1店",
                                        "parentId": 23200
                                    },
                                    {
                                        "children": [],
                                        "id": 23220,
                                        "name": "北京分公司-大兴支行-黄村西大街2店",
                                        "parentId": 23200
                                    },
                                    {
                                        "children": [],
                                        "id": 23230,
                                        "name": "北京分公司-大兴支行-黄村西大街3店",
                                        "parentId": 23200
                                    }
                                ],
                                "id": 23200,
                                "name": "北京分公司-大兴支行-黄村西大街分店",
                                "parentId": 23000
                            }
                        ],
                        "id": 23000,
                        "name": "北京分公司-大兴支行",
                        "parentId": 20000
                    }
                ],
                "id": 20000,
                "name": "北京分公司",
                "parentId": 10000
            },
            {
                "children": [
                    {
                        "children": [
                            {
                                "children": [],
                                "id": 31100,
                                "name": "天津分公司-滨海新区支行-塘沽街道分店",
                                "parentId": 31000
                            },
                            {
                                "children": [],
                                "id": 31110,
                                "name": "天津分公司-滨海新区支行-塘沽街道1店",
                                "parentId": 31000
                            },
                            {
                                "children": [],
                                "id": 31120,
                                "name": "天津分公司-滨海新区支行-塘沽街道2店",
                                "parentId": 31000
                            },
                            {
                                "children": [],
                                "id": 31130,
                                "name": "天津分公司-滨海新区支行-胡家园街道分店",
                                "parentId": 31000
                            },
                            {
                                "children": [],
                                "id": 31140,
                                "name": "天津分公司-滨海新区支行-胡家园街道1店",
                                "parentId": 31000
                            },
                            {
                                "children": [],
                                "id": 31150,
                                "name": "天津分公司-滨海新区支行-胡家园街道2店",
                                "parentId": 31000
                            }
                        ],
                        "id": 31000,
                        "name": "天津分公司-滨海新区支行",
                        "parentId": 30000
                    }
                ],
                "id": 30000,
                "name": "天津分公司",
                "parentId": 10000
            },
            {
                "children": [
                    {
                        "children": [
                            {
                                "children": [
                                    {
                                        "children": [],
                                        "id": 41110,
                                        "name": "河北分公司-邢台支行-宁晋支行-世爵公馆1店",
                                        "parentId": 41100
                                    },
                                    {
                                        "children": [],
                                        "id": 41120,
                                        "name": "河北分公司-邢台支行-宁晋支行-世爵公馆2店",
                                        "parentId": 41100
                                    }
                                ],
                                "id": 41100,
                                "name": "河北分公司-邢台支行-宁晋支行",
                                "parentId": 41000
                            }
                        ],
                        "id": 41000,
                        "name": "河北分公司-邢台支行",
                        "parentId": 40000
                    },
                    {
                        "children": [
                            {
                                "children": [
                                    {
                                        "children": [],
                                        "id": 42110,
                                        "name": "河北分公司-石家庄支行-机场路支行1点",
                                        "parentId": 42100
                                    },
                                    {
                                        "children": [],
                                        "id": 42120,
                                        "name": "河北分公司-石家庄支行-机场路支行2店",
                                        "parentId": 42100
                                    }
                                ],
                                "id": 42100,
                                "name": "河北分公司-石家庄支行-机场路支行",
                                "parentId": 42000
                            }
                        ],
                        "id": 42000,
                        "name": "河北分公司-石家庄支行",
                        "parentId": 40000
                    }
                ],
                "id": 40000,
                "name": "河北分公司",
                "parentId": 10000
            }
        ],
        "id": 10000,
        "name": "总部",
        "parentId": 0
    }
]
;
$(document).ready(function(){
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
});