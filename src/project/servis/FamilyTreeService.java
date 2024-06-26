package project.servis;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import project.FamilyTree.FamilyTree;
import project.FamilyTree.FamilyTreeIMPL;
import project.FileHandler.FileHandler;
import project.Members.Human;
import project.Members.TreeMember;

public class FamilyTreeService {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public FamilyTreeService() {
        this.familyTree = new FamilyTreeIMPL<>();
        this.fileHandler = fileHandler;
    }

    public void loadFamilyTree(String filename) throws IOException, ClassNotFoundException {
        this.familyTree = (FamilyTree<Human>) fileHandler.readFromFile(filename);
    }

    public void saveFamilyTree(String filename) throws IOException {
        fileHandler.writeToFile(filename, (Serializable) familyTree);
    }

    public boolean addMember(Human member) {
        return familyTree.addMember(member);
    }

    public List<String> getMemberDescriptions() {
        return familyTree.getMemberDescriptions();
    }

    public TreeMember getHumanByName(String name) {
        return familyTree.getHumanByName(name);
    }

    public List<TreeMember> getChildrenOf(Human member) {
        return familyTree.getChildrenOf(member);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }
}