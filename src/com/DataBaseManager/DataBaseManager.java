package com.DataBaseManager;

import com.DataClasses.Manager;
import com.DataClasses.Member;
import com.DataClasses.Provider;
import com.DataClasses.Service;
import com.ReadWrite.ReadWrite;

import java.util.TreeMap;

public class DataBaseManager<E> {
    /* Populate tree with array of objects
    Takes a tree root and an array of objects to populate the tree.
    Returns the number of objects added to the tree.
     */

    private TreeMap<String, Object> providers;
    private TreeMap<String, Object> members;
    private TreeMap<String, Object> managers;
    TreeMap<String, Object> services;

    public DataBaseManager() {
        this.providers = buildTree("data/providers.csv");
        this.members = buildTree("data/members.csv");
        this.managers = buildTree("data/managers.csv");
        this.services = buildTree("data/services.csv");
    }

    private TreeMap<String, Object> buildTree(String filename) {
        TreeMap<String, Object> root = new TreeMap<>();
        ReadWrite rw = new ReadWrite();
        if (rw == null)
            return null;

        String[] fileData = rw.fileRead(filename);
        String objectType = fileData[0];

        for (int i = 1; i < fileData.length; i++) {
            // Need to do some sort of RTTI depending on the filename
            String[] lineData = fileData[i].split(",");

            Object newObject = null;

            switch (objectType) {
                case "Service":
                    newObject = new Service(lineData);
                    break;
                case "Provider":
                    newObject = new Provider(lineData);
                    break;
                case "Manager":
                    newObject = new Manager(lineData);
                    break;
                case "Member":
                    newObject = new Member(lineData);
                    break;
            }

            if (newObject != null)
                root.put(lineData[1], newObject);
        }

        return root;
    }

    /* Return the queried item
    Takes the object database tree root and the object id as an argument.
    Returns a reference to the object if found, or null if the object
    is not in the tree.
     */
    public E findData(TreeMap<String, E> root, String key) {
        return root.get(key);
    }

    /* Remove queried item from tree
    Takes the object tree root and the id of the object to be removed.
    Returns the object associated with the id, or null if the object
    was not in the tree.
     */
    public E removeTreeData(TreeMap<String, E> root, String key){
        return root.remove(key);
    }

    /* Add item to tree
    Takes the object tree root and the object to be added to the tree.
    Returns a reference to the previous object associated with the id,
    or null if there was no object associated with the id.
     */
    public E addTreeData(TreeMap<String, E> root, String key, E obj){
        return root.put(key, obj);
    }

    /* Update an item
    Takes the object tree root and the object to be updated.
    Returns a reference to the previous object associated with the id,
    or null if there was no object associated with the id.
     */
    public E updateTreeData(TreeMap<String, E> root, String key, E obj){
        return root.replace(key, obj);
    }
}
