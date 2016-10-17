# XList
XList extends RecyclerView for Android DEV.

Ok, use bind action on your list view (another words, for recycler view).

```
<XList>.bind(<Your data list>, new <Your BindPolicy>(R.layout.people_item)).onItemClick(new XListOnItemClickListener() {
            @Override
            public void onItemClick(View v, Object data) {
              // For example, handle click action.
            }
        });
```
